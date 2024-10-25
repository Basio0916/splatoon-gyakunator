/**
 * 質問の型
 * @param prompts 質問のリスト
 * @param isNumeric 数値かどうか
 * @param isComparable 比較可能かどうか
 * @param unit 単位
 * @param questionName 質問の名前
 */
export type Prompt = {
  prompts: Array<string>;
  isNumeric: boolean;
  isComparable: boolean;
  unit: string;
  questionName: string;
};
