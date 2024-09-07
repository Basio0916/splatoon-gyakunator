import { Button, Card, Modal, Stack } from "@mui/material";
import { AnswerHistory } from "./AnswerHistory";
import { Answer } from "../types/Answer";
import { FC } from "react";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  weapon: string;
};

export const AnswerModal: FC<Props> = (props) => {
  const { open, setOpen, weapon } = props;
  const handleClose = (_event: {}, reason: string) => {
    if (reason !== "backdropClick") {
      setOpen(false);
    }
  };
  const onClick = (_event: React.MouseEvent<HTMLButtonElement>) => {
    setOpen(false);
  };
  return (
    <Modal open={open} onClose={handleClose} sx={{}}>
      <Card
        sx={{
          padding: "20px",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          position: "absolute",
          top: "50%",
          left: "50%",
          transform: "translate(-50%, -50%)",
          outline: "none",
        }}
      >
        <h2>正解は{weapon}でした</h2>
        <Button
          variant="contained"
          sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
          onClick={onClick}
        >
          再度遊ぶ
        </Button>
      </Card>
    </Modal>
  );
};
