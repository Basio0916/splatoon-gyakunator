import { render, screen, fireEvent } from "@testing-library/react";
import { AnswerModal } from "../../src/components/AnswerModal";
import { Answer } from "../../src/types/Answer";
import { AnswerStatus } from "../../src/types/AnswerStatus";
import "@testing-library/jest-dom";

describe("AnswerModal", () => {
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

  it("正しくモーダルが表示されること", () => {
    render(
      <AnswerModal
        open={true}
        setOpen={() => {}}
        answerHistory={answerHistory}
      />
    );

    expect(
      screen.getByText("正解はわかばシューターでした")
    ).toBeInTheDocument();
    expect(screen.getByTestId("answer-history")).toBeInTheDocument();
    expect(screen.getByText("再度遊ぶ")).toBeInTheDocument();
  });

  it("再度遊ぶボタンがクリックされた時に onClose コールバックが呼ばれること", () => {
    const onClose = jest.fn();
    const setOpen = jest.fn();
    render(
      <AnswerModal
        open={true}
        setOpen={setOpen}
        answerHistory={answerHistory}
        onClose={onClose}
      />
    );

    fireEvent.click(screen.getByText("再度遊ぶ"));

    expect(onClose).toHaveBeenCalled();
    expect(setOpen).toHaveBeenCalledWith(false);
  });

  it("行がクリックされた時にonClickAnswerコールバックが呼ばれること", () => {
    const onClickAnswer = jest.fn();
    render(
      <AnswerModal
        open={true}
        setOpen={() => {}}
        answerHistory={answerHistory}
        onClickAnswer={onClickAnswer}
      />
    );

    fireEvent.click(screen.getByText("わかばシューター"));

    expect(onClickAnswer).toHaveBeenCalledWith(answerHistory[0]);
  });
});
