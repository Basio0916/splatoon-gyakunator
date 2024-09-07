import { useState } from "react";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";
import { GameStartModal } from "./components/GameStartModal";
import { CorrectAnswerModal } from "./components/CorrectAnswerModal";
import { IncorrectAnswerModal } from "./components/IncorrectAnswerModal";
import { AnswerModal } from "./components/AnswerModal";
import { QuestionModal } from "./components/QuestionModal";
import questions from "./data/question.json";
import { CreateQuestion } from "./QuestionParser";
import { QuestionAnswer } from "./types/QuestionAnswer";
import { QuestionAnswerHistory } from "./components/QuestionAnswerHistory";
import { Button, Stack } from "@mui/material";

const answerHistory: Array<Answer> = [
  {
    weapon: "スプラシューター",
    questionCount: 10,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
];

function App() {
  const [answerModalOpen, setAnswerModalOpen] = useState(false);
  const [incorrectAnswerModalOpen, setIncorrectAnswerModalOpen] =
    useState(false);
  const [correctAnswerModalOpen, setCorrectAnswerModalOpen] = useState(false);
  const [gameStartModalOpen, setGameStartModalOpen] = useState(false);
  const [questionModalOpen, setQuestionModalOpen] = useState(false);
  const [questionAnswers, setQuestionAnswers] = useState<Array<QuestionAnswer>>(
    []
  );
  const question = CreateQuestion(questions);

  const handleClickQuestion = () => {
    setQuestionModalOpen(true);
  };

  const handleClickAnswer = () => {
    setAnswerModalOpen(true);
  };
  return (
    <>
      <Header />
      <IncorrectAnswerModal
        incorrectAnswerModalOpen={incorrectAnswerModalOpen}
        setIncorrectAnswerModalOpen={setIncorrectAnswerModalOpen}
        setAnswerModalOpen={setAnswerModalOpen}
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
