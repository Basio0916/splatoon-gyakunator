import { Button } from "@mui/material";
import { AnswerHistory } from "./components/AnswerHistory";
import { Header } from "./components/Header";
import { Answer } from "./types/Answer";

const answerHistory: Array<Answer> = [
  {
    weapon: "スプラシューター",
    questionCount: 10,
  },
  {
    weapon: "ホットブラスター",
    questionCount: 9,
  },
];

function App() {
  return (
    <>
      <Header />
      <div
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <div style={{ maxWidth: "600px", width: "100%" }}>
          <AnswerHistory answerHistory={answerHistory} />
        </div>
        <div
          style={{
            margin: 10,
          }}
        >
          <Button variant="contained" sx={{ width: "150px", fontSize: "18px" }}>
            スタート
          </Button>
        </div>
      </div>
    </>
  );
}

export default App;
