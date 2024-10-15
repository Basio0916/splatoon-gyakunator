const toKatakana = (input: string): string => {
  return input.replace(/[\u3041-\u3096]/g, (char) =>
    String.fromCharCode(char.charCodeAt(0) + 0x60)
  );
};

const toHiragana = (input: string): string => {
  return input.replace(/[\u30A1-\u30F6]/g, (char) =>
    String.fromCharCode(char.charCodeAt(0) - 0x60)
  );
};

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
