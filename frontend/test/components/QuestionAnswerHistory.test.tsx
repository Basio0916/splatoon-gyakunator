import { render, screen } from "@testing-library/react";
import { QuestionAnswerHistory } from "../../src/components/QuestionAnswerHistory";
import { AnswerStatus } from "../../src/types/AnswerStatus";
import "@testing-library/jest-dom";

describe("QuestionAnswerHistory", () => {
  const questionAnswers = [
    { question: "Question 1", answer: AnswerStatus.Yes },
    { question: "Question 2", answer: AnswerStatus.No },
    { question: "Question 3", answer: AnswerStatus.Partial },
  ];

  it("質問履歴が表示されること", () => {
    render(<QuestionAnswerHistory questionAnswers={questionAnswers} />);

    expect(screen.getByText("質問履歴")).toBeInTheDocument();
    expect(screen.getByText("No.")).toBeInTheDocument();
    expect(screen.getByText("質問")).toBeInTheDocument();
    expect(screen.getByText("結果")).toBeInTheDocument();

    questionAnswers.forEach((qa, index) => {
      expect(
        screen.getByText(String(questionAnswers.length - index))
      ).toBeInTheDocument();
      expect(screen.getByText(qa.question)).toBeInTheDocument();

      if (qa.answer === AnswerStatus.Yes) {
        expect(screen.getByTestId("yes-icon")).toBeInTheDocument();
      } else if (qa.answer === AnswerStatus.No) {
        expect(screen.getByTestId("no-icon")).toBeInTheDocument();
      } else {
        expect(screen.getByTestId("partial-icon")).toBeInTheDocument();
      }
    });
  });
});
