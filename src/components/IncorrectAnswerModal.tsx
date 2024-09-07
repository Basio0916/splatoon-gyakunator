import { Button, Card, Modal, Stack } from "@mui/material";
import { FC } from "react";

type Props = {
  incorrectAnswerModalOpen: boolean;
  setIncorrectAnswerModalOpen: (open: boolean) => void;
  setAnswerModalOpen: (open: boolean) => void;
};

export const IncorrectAnswerModal: FC<Props> = (props) => {
  const {
    incorrectAnswerModalOpen,
    setIncorrectAnswerModalOpen,
    setAnswerModalOpen,
  } = props;
  const handleClose = (_event: {}, reason: string) => {
    if (reason !== "backdropClick") {
      setIncorrectAnswerModalOpen(false);
    }
  };
  const onClick = (_event: React.MouseEvent<HTMLButtonElement>) => {
    setIncorrectAnswerModalOpen(false);
    setAnswerModalOpen(true);
  };
  return (
    <Modal open={incorrectAnswerModalOpen} onClose={handleClose} sx={{}}>
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
        <h1>不正解</h1>
        <Stack spacing={2} direction="row">
          <Button
            variant="contained"
            sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
            onClick={onClick}
          >
            続ける
          </Button>
          <Button
            variant="outlined"
            color="error"
            sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
            onClick={onClick}
          >
            あきらめる
          </Button>
        </Stack>
      </Card>
    </Modal>
  );
};
