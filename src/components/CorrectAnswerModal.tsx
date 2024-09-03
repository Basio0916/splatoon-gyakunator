import { Button, Card, Modal } from "@mui/material";
import { AnswerHistory } from "./AnswerHistory";
import { Answer } from "../types/Answer";
import { FC } from "react";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  answerHistory: Array<Answer>;
};

export const CorrectAnswerModal: FC<Props> = (props) => {
  const { open, setOpen, answerHistory } = props;
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
          padding: "10px",
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
        <h1>正解</h1>
        <div style={{ minWidth: "400px", width: "100%" }}>
          <AnswerHistory answerHistory={answerHistory} />
        </div>
        <Button
          variant="contained"
          sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
          onClick={onClick}
        >
          スタート
        </Button>
      </Card>
    </Modal>
  );
};
