import { render, screen, fireEvent } from "@testing-library/react";
import { HowToPlayModal } from "../../src/components/HowToPlayModal";
import "@testing-library/jest-dom";

describe("HowToPlayModal", () => {
  it("正しくモーダルが表示されること", () => {
    render(
      <HowToPlayModal open={true} setOpen={() => {}} onClose={() => {}} />
    );

    // 他の文言は変更されうるので、スタートボタンのみを検証
    expect(screen.getByText("スタート")).toBeInTheDocument();
  });

  it("スタートボタンがクリックされた時にonCloseが呼ばれること", () => {
    const onClose = jest.fn();
    render(<HowToPlayModal open={true} setOpen={() => {}} onClose={onClose} />);

    fireEvent.click(screen.getByText("スタート"));

    expect(onClose).toHaveBeenCalled();
  });
});
