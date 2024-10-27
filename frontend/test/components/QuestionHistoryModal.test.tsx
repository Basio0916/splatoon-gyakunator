import { render, screen, fireEvent } from "@testing-library/react";
import { QuestionHistoryModal } from "../../src/components/QuestionHistoryModal";
import "@testing-library/jest-dom";
import { AnswerStatus } from "../../src/types/AnswerStatus";
import React from "react";

describe("QuestionHistoryModal", () => {
  const questionHistory = [
    { question: "Question 1", answer: AnswerStatus.Yes },
    { question: "Question 2", answer: AnswerStatus.No },
    { question: "Question 3", answer: AnswerStatus.Partial },
  ];

  it("モーダルが正しく表示されること", () => {
    render(
      <QuestionHistoryModal
        open={true}
        setOpen={() => {}}
        questionHistory={questionHistory}
      />
    );
    expect(screen.getByTestId("question-answer-history")).toBeInTheDocument();
    expect(screen.getByTestId("close-icon")).toBeInTheDocument();
  });

  it("handleCloseが呼ばれた時にモーダルが閉じること", () => {
    const setOpen = jest.fn();
    render(
      <QuestionHistoryModal
        open={true}
        setOpen={setOpen}
        questionHistory={questionHistory}
      />
    );

    fireEvent.click(screen.getByTestId("close-icon"));

    expect(setOpen).toHaveBeenCalledWith(false);
  });
});
