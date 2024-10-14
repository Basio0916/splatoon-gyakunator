import { Question } from "./types/Question";

type RawQuestion = {
  mainQuestion: string;
  subQuestion: string;
  option: string;
  isNumeric: string;
  isComparable: string;
  unit: string;
  questionName: string;
};

type RawWeapon = {
  name: string;
  mainWeapon: string;
  subWeapon: string;
  specialWeapon: string;
  specialPoint: string;
};

export const CreateQuestion = (
  rawQuestion: Array<RawQuestion>
): Array<Question> => {
  return rawQuestion.map((question) => {
    const questions = [
      question.mainQuestion,
      question.subQuestion,
      question.option,
    ].filter((item) => item !== "");
    const isNumeric = question.isNumeric === "TRUE";
    const isComparable = question.isComparable === "TRUE";
    const unit = question.unit;
    const questionName = question.questionName;
    return {
      questions,
      isNumeric,
      isComparable,
      unit,
      questionName,
    };
  });
};

export const CreateWeapons = (rawWeapon: Array<RawWeapon>): Array<string> => {
  return rawWeapon.map((weapon) => weapon.name);
};
