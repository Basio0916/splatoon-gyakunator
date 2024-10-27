import { render, screen, fireEvent } from "@testing-library/react";
import { IncorrectAnswerModal } from "../../src/components/IncorrectAnswerModal";
import "@testing-library/jest-dom";

describe("IncorrectAnswerModal", () => {
  it("正しくモーダルが表示されること", () => {
    const setOpen = jest.fn();
    render(<IncorrectAnswerModal open={true} setOpen={setOpen} />);

    expect(screen.getByText("不正解")).toBeInTheDocument();
    expect(screen.getByText("続ける")).toBeInTheDocument();
    expect(screen.getByText("あきらめる")).toBeInTheDocument();
  });

  it("続けるボタンがクリックされた時にonCloseコールバックが呼ばれること", () => {
    const setOpen = jest.fn();
    const onClose = jest.fn();
    render(
      <IncorrectAnswerModal open={true} setOpen={setOpen} onClose={onClose} />
    );

    fireEvent.click(screen.getByText("続ける"));

    expect(onClose).toHaveBeenCalledWith(false);
    expect(setOpen).toHaveBeenCalledWith(false);
  });

  it("あきらめるボタンがクリックされた時に onClose コールバックが呼ばれること", () => {
    const setOpen = jest.fn();
    const onClose = jest.fn();
    render(
      <IncorrectAnswerModal open={true} setOpen={setOpen} onClose={onClose} />
    );

    fireEvent.click(screen.getByText("あきらめる"));

    expect(onClose).toHaveBeenCalledWith(true);
    expect(setOpen).toHaveBeenCalledWith(false);
  });
});
