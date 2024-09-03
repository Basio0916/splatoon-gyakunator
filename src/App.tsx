import { useState } from "react";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";
import { GameStartModal } from "./components/GameStartModal";
import { CorrectAnswerModal } from "./components/CorrectAnswerModal";

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
      <CorrectAnswerModal
        open={open}
        setOpen={setOpen}
        answerHistory={answerHistory}
      />
    </>
  );
}

export default App;
