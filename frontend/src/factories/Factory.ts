import { Prompt } from "../types/Prompt";

/**
 * JSONで定義されている質問の型
 * @param prompt1 質問1
 * @param prompt2 質問2
 * @param prompt3 質問3
 * @param isNumeric 数値かどうか
 * @param isComparable 比較可能かどうか
 * @param unit 単位
 * @param questionName 質問の名前
 */
type RawPrompt = {
  prompt1: string;
  prompt2: string;
  prompt3: string;
  isNumeric: string;
  isComparable: string;
  unit: string;
  questionName: string;
};

/**
 * JSONの質問の型をアプリケーションの質問の型に変換する
 * @param rawPrompts JSONの質問の型
 * @returns アプリケーションで使用する質問の型
 */
export const createPrompts = (rawPrompts: Array<RawPrompt>): Array<Prompt> => {
  return rawPrompts.map((prompt) => {
    const prompts = [prompt.prompt1, prompt.prompt2, prompt.prompt3].filter(
      (item) => item !== ""
    );
    const isNumeric = prompt.isNumeric === "TRUE";
    const isComparable = prompt.isComparable === "TRUE";
    const unit = prompt.unit;
    const questionName = prompt.questionName;
    return {
      prompts,
      isNumeric,
      isComparable,
      unit,
      questionName,
    };
  });
};

/**
 * JSONで定義されているブキの型
 * @param name ブキの名前
 * @param mainWeapon メインウェポン
 * @param subWeapon サブウェポン
 * @param specialWeapon スペシャルウェポン
 * @param specialPoint スペシャル必要ポイント
 */
type RawWeapon = {
  name: string;
  mainWeapon: string;
  subWeapon: string;
  specialWeapon: string;
  specialPoint: string;
};

/**
 * JSONのブキの型をアプリケーションのブキの型に変換する
 * @param rawWeapon JSONのブキの型
 * @returns アプリケーションで使用するブキの型
 */
export const createWeapons = (rawWeapon: Array<RawWeapon>): Array<string> => {
  return rawWeapon.map((weapon) => weapon.name);
};
