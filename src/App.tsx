import { useState } from "react";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";
import { HowToPlayModal } from "./components/HowToPlayModal";
import { CorrectAnswerModal } from "./components/CorrectAnswerModal";
import { IncorrectAnswerModal } from "./components/IncorrectAnswerModal";
import { AnswerModal } from "./components/AnswerModal";
import { QuestionModal } from "./components/QuestionModal";
import questions from "./data/question.json";
import buki from "./data/buki.json";
import { CreateQuestion, CreateWeapons } from "./QuestionParser";
import { QuestionAnswer } from "./types/QuestionAnswer";
import { QuestionAnswerHistory } from "./components/QuestionAnswerHistory";
import { Box, Button, Stack } from "@mui/material";
import { AnswerSubmissionModal } from "./components/AnswerSubmissionModal";

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
  const question = CreateQuestion(questions);
  const weapons = CreateWeapons(buki);

  const handleClickQuestion = () => {
    setQuestionModalOpen(true);
  };

  const handleClickAnswer = () => {
    setAnswerSubmissionModalOpen(true);
  };

  const handleCorrectAnswerModalClose = () => {
    setQuestionAnswers([]);
  };

  const handleIncorrectAnswerModalClose = (retire: boolean) => {
    if (retire) {
      setAnswerModalOpen(true);
    } else {
      const questionAnswer: QuestionAnswer = {
        question: `ブキは${submittedAnswer}？`,
        answer: false,
      };
      setQuestionAnswers([questionAnswer, ...questionAnswers]);
    }
  };

  const handleAnswerModalClose = () => {
    setQuestionAnswers([]);
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
        weapon="もみじシューター"
        onClose={handleAnswerModalClose}
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
        onClose={handleAnswerSubmissionModalClose}
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
