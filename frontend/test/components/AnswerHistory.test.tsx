import { render, screen, fireEvent } from "@testing-library/react";
import { AnswerHistory } from "../../src/components/AnswerHistory";
import { Answer } from "../../src/types/Answer";
import { AnswerStatus } from "../../src/types/AnswerStatus";
import "@testing-library/jest-dom";

describe("AnswerHistory", () => {
  const answerHistory: Array<Answer> = [
    {
      weapon: "わかばシューター",
      isCorrect: true,
      questionHistory: [
        { question: "Question 1", answer: AnswerStatus.Yes },
        { question: "Question 2", answer: AnswerStatus.Yes },
      ],
    },
    {
      weapon: "スプラローラー",
      isCorrect: false,
      questionHistory: [{ question: "Question 3", answer: AnswerStatus.No }],
    },
  ];

  it("コンポーネントが正しく表示されること", () => {
    render(<AnswerHistory answerHistory={answerHistory} />);

    expect(screen.getByText("答えのブキ")).toBeInTheDocument();
    expect(screen.getByText("正解/不正解")).toBeInTheDocument();
    expect(screen.getByText("質問回数")).toBeInTheDocument();

    expect(screen.getByText("わかばシューター")).toBeInTheDocument();
    expect(screen.getByText("正解")).toBeInTheDocument();
    expect(screen.getByText("2")).toBeInTheDocument();

    expect(screen.getByText("スプラローラー")).toBeInTheDocument();
    expect(screen.getByText("不正解")).toBeInTheDocument();
    expect(screen.getByText("1")).toBeInTheDocument();
  });

  it("行がクリックされたときにonClickコールバックが呼び出されること", () => {
    const onClick = jest.fn();
    render(<AnswerHistory answerHistory={answerHistory} onClick={onClick} />);

    fireEvent.click(screen.getByText("わかばシューター"));

    expect(onClick).toHaveBeenCalledWith(answerHistory[0]);
  });
});
