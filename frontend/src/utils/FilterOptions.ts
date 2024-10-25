/**
 * ひらがなをカタカナに変換する
 * @param input ひらがな
 * @returns カタカナ
 */
const toKatakana = (input: string): string => {
  return input.replace(/[\u3041-\u3096]/g, (char) =>
    String.fromCharCode(char.charCodeAt(0) + 0x60)
  );
};

/**
 * カタカナをひらがなに変換する
 * @param input カタカナ
 * @returns ひらがな
 */
const toHiragana = (input: string): string => {
  return input.replace(/[\u30A1-\u30F6]/g, (char) =>
    String.fromCharCode(char.charCodeAt(0) - 0x60)
  );
};

/**
 * Autocompleteコンポーネントでオプションをフィルタリングする
 * ひらがな、カタカナ、大文字、小文字を区別せずにフィルタリングする
 * @param options オプション
 * @param inputValue 入力値
 * @returns フィルターオプション
 */
export const filterOptions = (
  options: string[],
  { inputValue }: { inputValue: string }
) => {
  const lowerCaseInput = inputValue.toLowerCase();
  const katakanaInput = toKatakana(lowerCaseInput);
  const hiraganaInput = toHiragana(lowerCaseInput);

  return options.filter((option) => {
    const lowerCaseOption = option.toLowerCase();

    return (
      lowerCaseOption.includes(lowerCaseInput) ||
      lowerCaseOption.includes(katakanaInput) ||
      lowerCaseOption.includes(hiraganaInput)
    );
  });
};
