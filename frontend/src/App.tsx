import { useState } from "react";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";
import { HowToPlayModal } from "./components/HowToPlayModal";
import { CorrectAnswerModal } from "./components/CorrectAnswerModal";
import { IncorrectAnswerModal } from "./components/IncorrectAnswerModal";
import { AnswerModal } from "./components/AnswerModal";
import { QuestionModal } from "./components/QuestionModal";
import questionsJson from "./data/Questions.json";
import weaponsJson from "./data/Weapons.json";
import { CreateQuestion, CreateWeapons } from "./QuestionParser";
import { QuestionAnswer } from "./types/QuestionAnswer";
import { QuestionAnswerHistory } from "./components/QuestionAnswerHistory";
import { Box, Button, Stack } from "@mui/material";
import { AnswerSubmissionModal } from "./components/AnswerSubmissionModal";
import { AnswerStatus } from "./types/AnswerStatus";

function App() {
  const [answerModalOpen, setAnswerModalOpen] = useState(false);
  const [incorrectAnswerModalOpen, setIncorrectAnswerModalOpen] =
    useState(false);
  const [correctAnswerModalOpen, setCorrectAnswerModalOpen] = useState(false);
  const [gameStartModalOpen, setGameStartModalOpen] = useState(true);
  const [questionModalOpen, setQuestionModalOpen] = useState(false);
  const [answerSubmissionModalOpen, setAnswerSubmissionModalOpen] =
    useState(false);
  const [questionAnswers, setQuestionAnswers] = useState<Array<QuestionAnswer>>(
    []
  );
  const [submittedAnswer, setSubmittedAnswer] = useState<string>("");
  const [answerHistory, setAnswerHistory] = useState<Array<Answer>>([]);
  const [answerWeapon, setAnswerWeapon] = useState<string>("");
  const [jwt, setJwt] = useState<string>("");
  const questions = CreateQuestion(questionsJson);
  const weapons = CreateWeapons(weaponsJson);

  const gameStart = async () => {
    try {
      const response = await fetch("http://localhost:9000/api/game/start");
      response.json().then((data) => {
        setJwt(data.jwt);
      });
    } catch (error) {
      console.error(error);
    }
  };

  const getAnswerWeapon = async () => {
    try {
      const json = { jwt: jwt };
      const response = await fetch(
        "http://localhost:9000/api/game/weaponname",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(json),
        }
      );
      const data = await response.json();
      setAnswerWeapon(data.weaponName);
    } catch (error) {
      console.error(error);
    }
  };

  const handleHowToPlayModalClose = async () => {
    await gameStart();
  };

  const handleClickQuestion = () => {
    setQuestionModalOpen(true);
  };

  const handleClickAnswer = () => {
    setAnswerSubmissionModalOpen(true);
  };

  const handleCorrectAnswerModalClose = async () => {
    setQuestionAnswers([]);
    await gameStart();
  };

  const handleIncorrectAnswerModalClose = async (retire: boolean) => {
    if (retire) {
      await getAnswerWeapon();
      setAnswerModalOpen(true);
    } else {
      const questionAnswer: QuestionAnswer = {
        question: `ブキは${submittedAnswer}？`,
        answer: AnswerStatus.No,
      };
      setQuestionAnswers([questionAnswer, ...questionAnswers]);
    }
  };

  const handleAnswerModalClose = async () => {
    setQuestionAnswers([]);
    await gameStart();
  };

  const handleAnswerSubmissionModalClose = (
    weapon: string,
    result: boolean
  ) => {
    setSubmittedAnswer(weapon);
    if (result) {
      const answer: Answer = {
        weapon: weapon,
        questionCount: questionAnswers.length,
      };
      setAnswerHistory([answer, ...answerHistory]);
      setCorrectAnswerModalOpen(true);
    } else {
      setIncorrectAnswerModalOpen(true);
    }
  };

  return (
    <>
      <Header />
      <HowToPlayModal
        open={gameStartModalOpen}
        setOpen={setGameStartModalOpen}
        onClose={handleHowToPlayModalClose}
      />
      <CorrectAnswerModal
        open={correctAnswerModalOpen}
        setOpen={setCorrectAnswerModalOpen}
        answerHistory={answerHistory}
        onClose={handleCorrectAnswerModalClose}
      />
      <IncorrectAnswerModal
        open={incorrectAnswerModalOpen}
        setOpen={setIncorrectAnswerModalOpen}
        onClose={handleIncorrectAnswerModalClose}
      />
      <AnswerModal
        open={answerModalOpen}
        setOpen={setAnswerModalOpen}
        weapon={answerWeapon}
        onClose={handleAnswerModalClose}
      />
      <QuestionModal
        open={questionModalOpen}
        setOpen={setQuestionModalOpen}
        questions={questions}
        questionAnswers={questionAnswers}
        setQuestionAnswers={setQuestionAnswers}
        jwt={jwt}
      />
      <AnswerSubmissionModal
        open={answerSubmissionModalOpen}
        setOpen={setAnswerSubmissionModalOpen}
        weapons={weapons}
        onClose={handleAnswerSubmissionModalClose}
        jwt={jwt}
      />
      <Box
        sx={{
          width: "90%",
          maxWidth: "800px",
          display: "flex",
          flexDirection: "column",
          position: "absolute",
          alignItems: "center",
          left: "50%",
          transform: "translate(-50%, 0%)",
        }}
      >
        <QuestionAnswerHistory questionAnswers={questionAnswers} />
        <Stack spacing={2} direction="row" sx={{ margin: "10px" }}>
          <Button
            variant="contained"
            color="primary"
            sx={{
              width: "150px",
              fontSize: "18px",
              marginTop: "10px",
            }}
            onClick={handleClickQuestion}
          >
            質問する
          </Button>
          <Button
            variant="outlined"
            color="primary"
            sx={{
              width: "150px",
              fontSize: "18px",
              marginTop: "10px",
            }}
            onClick={handleClickAnswer}
          >
            回答する
          </Button>
        </Stack>
      </Box>
    </>
  );
}

export default App;
