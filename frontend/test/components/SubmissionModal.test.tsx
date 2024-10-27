import { render, screen, fireEvent } from "@testing-library/react";
import { SubmissionModal } from "../../src/components/SubmissionModal";
import "@testing-library/jest-dom";
import userEvent from "@testing-library/user-event";

describe("SubmissionModal", () => {
  const weapons = ["Weapon 1", "Weapon 2", "Weapon 3"];

  it("モーダルが正しく表示されること", () => {
    const onClose = jest.fn();
    const setOpen = jest.fn();
    render(
      <SubmissionModal
        open={true}
        setOpen={setOpen}
        weapons={weapons}
        onClose={onClose}
      />
    );

    expect(screen.getByTestId("close-icon")).toBeInTheDocument();
    expect(screen.getByLabelText("回答")).toBeInTheDocument();
    expect(
      screen.getByRole("button", { name: "回答する" })
    ).toBeInTheDocument();
  });

  it("回答するボタンがクリックされたときに選択されたブキを引数としてonCloseが呼び出されること", async () => {
    const onClose = jest.fn();
    const setOpen = jest.fn();
    render(
      <SubmissionModal
        open={true}
        setOpen={setOpen}
        weapons={weapons}
        onClose={onClose}
      />
    );

    const weaponInput = screen.getByLabelText("回答");
    userEvent.type(weaponInput, "Weapon 1");
    const option = await screen.findByText("Weapon 1");
    fireEvent.click(option);

    const answerButton = screen.getByRole("button", { name: "回答する" });
    fireEvent.click(answerButton);

    expect(onClose).toHaveBeenCalledWith("Weapon 1");
    expect(setOpen).toHaveBeenCalledWith(false);
  });

  it("クローズアイコンがクリックされたときにモーダルが閉じること", () => {
    const onClose = jest.fn();
    const setOpen = jest.fn();
    render(
      <SubmissionModal
        open={true}
        setOpen={setOpen}
        weapons={weapons}
        onClose={onClose}
      />
    );

    fireEvent.click(screen.getByTestId("close-icon"));

    expect(onClose).not.toHaveBeenCalled();
    expect(setOpen).toHaveBeenCalledWith(false);
  });
});
