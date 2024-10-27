import { render, screen, fireEvent } from "@testing-library/react";
import { QuestionModal } from "../../src/components/QuestionModal";
import "@testing-library/jest-dom";

describe("QuestionModal", () => {
  const questions = [
    {
      prompts: ["Question 1-1", "Question 1-2", "Question 1-3"],
      unit: "",
      isNumeric: false,
      isComparable: false,
      questionName: "質問3まである質問",
    },
    {
      prompts: ["Question 2-1", "Question 2-2"],
      unit: "",
      isNumeric: false,
      isComparable: false,
      questionName: "質問2まである質問",
    },
    {
      prompts: ["Question 3-1", "Question 3-2"],
      unit: "ダメージ",
      isNumeric: true,
      isComparable: true,
      questionName: "数値質問",
    },
    {
      prompts: ["Question 4-1", "Question 4-2", "Question 4-3"],
      unit: "",
      isNumeric: false,
      isComparable: true,
      questionName: "比較質問",
    },
  ];

  it("モーダルが正しく表示されること", () => {
    const onClose = jest.fn();
    const setOpen = jest.fn();
    render(
      <QuestionModal
        open={true}
        setOpen={setOpen}
        questions={questions}
        onClose={onClose}
      />
    );

    expect(screen.getByLabelText("質問1")).toBeInTheDocument();
    expect(screen.queryByLabelText("質問2")).not.toBeInTheDocument();
    expect(screen.queryByLabelText("質問3")).not.toBeInTheDocument();
    expect(screen.queryByLabelText("数値")).not.toBeInTheDocument();
    expect(screen.queryByLabelText("比較")).not.toBeInTheDocument();
    expect(screen.getByTestId("close-icon")).toBeInTheDocument();
  });

  it("クローズアイコンがクリックされたとき、モーダルが閉じること", () => {
    const onClose = jest.fn();
    const setOpen = jest.fn();
    render(
      <QuestionModal
        open={true}
        setOpen={setOpen}
        questions={questions}
        onClose={onClose}
      />
    );

    fireEvent.click(screen.getByTestId("close-icon"));

    expect(onClose).not.toHaveBeenCalled();
    expect(setOpen).toHaveBeenCalledWith(false);
  });
});
