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
import { apiUrl } from "./config";
import { ProgressModal } from "./components/ProgressModal";
import { QuestionHistoryModal } from "./components/QuestionHistoryModal";

function App() {
  const [answerModalOpen, setAnswerModalOpen] = useState(false);
  const [incorrectAnswerModalOpen, setIncorrectAnswerModalOpen] =
    useState(false);
  const [correctAnswerModalOpen, setCorrectAnswerModalOpen] = useState(false);
  const [gameStartModalOpen, setGameStartModalOpen] = useState(true);
  const [questionModalOpen, setQuestionModalOpen] = useState(false);
  const [answerSubmissionModalOpen, setAnswerSubmissionModalOpen] =
    useState(false);
  const [progressModalOpen, setProgressModalOpen] = useState(false);
  const [questionHistoryModalOpen, setQuestionHistoryModalOpen] =
    useState(false);

  const [questionAnswers, setQuestionAnswers] = useState<Array<QuestionAnswer>>(
    []
  );
  const [submittedAnswer, setSubmittedAnswer] = useState<string>("");
  const [answerHistory, setAnswerHistory] = useState<Array<Answer>>([]);
  const [selectedAnswersQuestionHistory, setSelectedAnswersQuestionHistory] =
    useState<Array<QuestionAnswer>>([]);
  const [jwt, setJwt] = useState<string>("");
  const questions = CreateQuestion(questionsJson);
  const weapons = CreateWeapons(weaponsJson);

  const gameStart = async () => {
    setProgressModalOpen(true);
    try {
      const response = await fetch(`${apiUrl}/api/start`);
      const data = await response.json();
      setJwt(data.jwt);
    } catch (error) {
      console.error(error);
    }
    setProgressModalOpen(false);
  };

  const getAnswerWeapon = async (): Promise<string> => {
    setProgressModalOpen(true);
    try {
      const response = await fetch(`${apiUrl}/api/answer`, {
        method: "GET",
        headers: {
          "X-Data-Token": jwt,
        },
      });
      const data = await response.json();
      return data.weaponName;
    } catch (error) {
      console.error(error);
    }
    setProgressModalOpen(false);
    return "";
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

  const handleClickAnswerRow = (answer: Answer) => {
    setSelectedAnswersQuestionHistory(answer.questionHistory);
    setQuestionHistoryModalOpen(true);
  };

  const handleCorrectAnswerModalClose = async () => {
    setQuestionAnswers([]);
    await gameStart();
  };

  const handleIncorrectAnswerModalClose = async (retire: boolean) => {
    if (retire) {
      const answerWeaponName = await getAnswerWeapon();

      const answer: Answer = {
        weapon: answerWeaponName,
        isCorrect: false,
        questionHistory: questionAnswers,
      };
      setAnswerHistory([answer, ...answerHistory]);
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

  const handleAnswerSubmissionModalClose = async (selectedWeapon: string) => {
    setSubmittedAnswer(selectedWeapon);
    setProgressModalOpen(true);
    try {
      const response = await fetch(`${apiUrl}/api/verify/${selectedWeapon}`, {
        method: "GET",
        headers: {
          "X-Data-Token": jwt,
        },
      });
      const data = await response.json();
      if (data.result) {
        const answer: Answer = {
          weapon: selectedWeapon,
          isCorrect: true,
          questionHistory: questionAnswers,
        };
        setAnswerHistory([answer, ...answerHistory]);
        setCorrectAnswerModalOpen(true);
      } else {
        setIncorrectAnswerModalOpen(true);
      }
    } catch (error) {
      console.error(error);
    }
    setProgressModalOpen(false);
  };

  const handleQuestionModalClose = async (
    questionString: string,
    questionName: string,
    option: string,
    comparator: string
  ) => {
    setProgressModalOpen(true);
    try {
      const optionQueryString = option ? `option=${option}` : "";
      const comparatorQueryString = comparator
        ? `&comparator=${comparator}`
        : "";
      const response = await fetch(
        `${apiUrl}/api/question/${questionName}?${optionQueryString}${comparatorQueryString}`,
        {
          method: "GET",
          headers: {
            "X-Data-Token": jwt,
          },
        }
      );

      const data = await response.json();
      const answer = AnswerStatus[data.answer as keyof typeof AnswerStatus];
      const questionAnswer: QuestionAnswer = {
        question: questionString,
        answer: answer,
      };
      setQuestionAnswers([questionAnswer, ...questionAnswers]);
    } catch (error) {
      console.error(error);
    }
    setProgressModalOpen(false);
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
        onClickAnswer={handleClickAnswerRow}
      />
      <IncorrectAnswerModal
        open={incorrectAnswerModalOpen}
        setOpen={setIncorrectAnswerModalOpen}
        onClose={handleIncorrectAnswerModalClose}
      />
      <AnswerModal
        open={answerModalOpen}
        setOpen={setAnswerModalOpen}
        answerHistory={answerHistory}
        onClose={handleAnswerModalClose}
        onClickAnswer={handleClickAnswerRow}
      />
      <QuestionModal
        open={questionModalOpen}
        setOpen={setQuestionModalOpen}
        questions={questions}
        onClose={handleQuestionModalClose}
      />
      <AnswerSubmissionModal
        open={answerSubmissionModalOpen}
        setOpen={setAnswerSubmissionModalOpen}
        weapons={weapons}
        onClose={handleAnswerSubmissionModalClose}
      />
      <QuestionHistoryModal
        open={questionHistoryModalOpen}
        setOpen={setQuestionHistoryModalOpen}
        questionHistory={selectedAnswersQuestionHistory}
      />
      <ProgressModal open={progressModalOpen} />
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
