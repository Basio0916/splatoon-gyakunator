import { useEffect, useState } from "react";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";
import { GameStartModal } from "./components/GameStartModal";
import { CorrectAnswerModal } from "./components/CorrectAnswerModal";
import { IncorrectAnswerModal } from "./components/IncorrectAnswerModal";
import { AnswerModal } from "./components/AnswerModal";
import { QuestionModal } from "./components/QuestionModal";
import questions from "./data/question.json";
import buki from "./data/buki.json";
import { CreateQuestion, CreateWeapons } from "./QuestionParser";
import { QuestionAnswer } from "./types/QuestionAnswer";
import { QuestionAnswerHistory } from "./components/QuestionAnswerHistory";
import { Button, Stack } from "@mui/material";
import { AnswerSubmissionModal } from "./components/AnswerSubmissionModal";

function App() {
  const [answerModalOpen, setAnswerModalOpen] = useState(false);
  const [incorrectAnswerModalOpen, setIncorrectAnswerModalOpen] =
    useState(false);
  const [correctAnswerModalOpen, setCorrectAnswerModalOpen] = useState(false);
  const [gameStartModalOpen, setGameStartModalOpen] = useState(false);
  const [questionModalOpen, setQuestionModalOpen] = useState(false);
  const [answerSubmissionModalOpen, setAnswerSubmissionModalOpen] =
    useState(false);
  const [questionAnswers, setQuestionAnswers] = useState<Array<QuestionAnswer>>(
    []
  );
  const [isFirstLoad, setIsFirstLoad] = useState(true);
  const [weapon, setWeapon] = useState<string>("");
  const [answer, setAnswer] = useState<boolean>(false);
  const [answerHistory, setAnswerHistory] = useState<Array<Answer>>([]);
  const question = CreateQuestion(questions);
  const weapons = CreateWeapons(buki);

  useEffect(() => {
    if (isFirstLoad) {
      return;
    }
    if (!answerSubmissionModalOpen) {
      if (answer) {
        setCorrectAnswerModalOpen(true);
      } else {
        setIncorrectAnswerModalOpen(true);
      }
    }
  }, [answerSubmissionModalOpen, answer]);

  useEffect(() => {
    if (isFirstLoad) {
      return;
    }
    if (!questionModalOpen) {
    }
  }, [correctAnswerModalOpen, incorrectAnswerModalOpen]);

  const handleClickQuestion = () => {
    setQuestionModalOpen(true);
  };

  const handleClickAnswer = () => {
    setAnswerSubmissionModalOpen(true);
  };

  const handleIncorrectAnswerModalClose = (retire: boolean) => {
    if (retire) {
      setAnswerModalOpen(true);
    }
  };

  useEffect(() => {
    if (isFirstLoad) {
      setIsFirstLoad(false);
      setGameStartModalOpen(true);
    }
  }, [isFirstLoad]);

  return (
    <>
      <Header />
      <GameStartModal
        open={gameStartModalOpen}
        setOpen={setGameStartModalOpen}
        answerHistory={answerHistory}
      />
      <CorrectAnswerModal
        open={correctAnswerModalOpen}
        setOpen={setCorrectAnswerModalOpen}
        answerHistory={answerHistory}
      />
      <IncorrectAnswerModal
        open={incorrectAnswerModalOpen}
        setOpen={setIncorrectAnswerModalOpen}
        onClose={handleIncorrectAnswerModalClose}
      />
      <AnswerModal
        open={answerModalOpen}
        setOpen={setAnswerModalOpen}
        weapon="もみじシューター"
      />
      <QuestionModal
        open={questionModalOpen}
        setOpen={setQuestionModalOpen}
        questions={question}
        questionAnswers={questionAnswers}
        setQuestionAnswers={setQuestionAnswers}
      />
      <AnswerSubmissionModal
        open={answerSubmissionModalOpen}
        setOpen={setAnswerSubmissionModalOpen}
        weapons={weapons}
        setWeapon={setWeapon}
        setAnswer={setAnswer}
      />
      <div
        style={{
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
        <Stack spacing={2} direction="row">
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
      </div>
    </>
  );
}

export default App;
