import { Question } from "./types/Question";

type RawQuestion = {
  大項目: string;
  中項目: string;
  小項目: string;
  質問数: string;
  数値: string;
  比較: string;
};

export const CreateQuestion = (
  rawQuestion: Array<RawQuestion>
): Array<Question> => {
  return rawQuestion.map((question) => {
    const questions = [
      question.大項目,
      question.中項目,
      question.小項目,
    ].filter((item) => item !== "");
    const isNumeric = question.数値 === "TRUE";
    const isComparable = question.比較 === "TRUE";
    return {
      questions,
      isNumeric,
      isComparable,
    };
  });
};
