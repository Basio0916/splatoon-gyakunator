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
  const [questionModalOpen, setQuestionModalOpen] = useState(true);
  const question = CreateQuestion(questions);
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
      />
    </>
  );
}

export default App;
