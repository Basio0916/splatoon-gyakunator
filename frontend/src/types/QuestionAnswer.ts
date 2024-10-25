import { AnswerStatus } from "./AnswerStatus";

/**
 * 質問とそれに対する回答を表す型
 * @param question 質問
 * @param answer 回答
 */
export type QuestionAnswer = {
  question: string;
  answer: AnswerStatus;
};
