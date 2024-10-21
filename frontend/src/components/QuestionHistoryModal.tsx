import { FC } from "react";
import { QuestionAnswerHistory } from "./QuestionAnswerHistory";
import { Box, IconButton, Modal } from "@mui/material";
import { QuestionAnswer } from "../types/QuestionAnswer";
import CloseIcon from "@mui/icons-material/Close";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  questionHistory: Array<QuestionAnswer>;
};

export const QuestionHistoryModal: FC<Props> = (props) => {
  const { open, setOpen, questionHistory } = props;
  const handleClose = () => {
    setOpen(false);
  };
  return (
    <Modal open={open} onClose={handleClose}>
      <Box
        sx={{
          width: "90%",
          maxWidth: "600px",
          padding: "30px",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          position: "absolute",
          top: "50%",
          left: "50%",
          transform: "translate(-50%, -50%)",
          outline: "none",
          overflow: "auto",
          maxHeight: "80%",
        }}
      >
        <IconButton
          aria-label="close"
          onClick={handleClose}
          sx={{
            position: "absolute",
            right: 40,
            top: 40,
            color: (theme) => theme.palette.grey[500],
          }}
        >
          <CloseIcon />
        </IconButton>
        <QuestionAnswerHistory questionAnswers={questionHistory} />
      </Box>
    </Modal>
  );
};