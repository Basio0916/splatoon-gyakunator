import { QuestionAnswer } from "./QuestionAnswer";

/**
 * 回答を表す型
 *
 * @property weapon 答えのブキ
 * @property questionHistory 回答までの質問の履歴
 */
export type Answer = {
  weapon: string;
  questionHistory: Array<QuestionAnswer>;
};
