import { useState } from "react";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";
import { GameStartModal } from "./components/GameStartModal";
import { CorrectAnswerModal } from "./components/CorrectAnswerModal";
import { IncorrectAnswerModal } from "./components/IncorrectAnswerModal";
import { AnswerModal } from "./components/AnswerModal";

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
  const [open, setOpen] = useState(true);
  return (
    <>
      <Header />
      <AnswerModal open={open} setOpen={setOpen} weapon="もみじシューター" />
    </>
  );
}

export default App;
