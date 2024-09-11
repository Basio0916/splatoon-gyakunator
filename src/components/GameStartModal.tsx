import { Box, Button, Card, Divider, Modal, Typography } from "@mui/material";
import { AnswerHistory } from "./AnswerHistory";
import { Answer } from "../types/Answer";
import { FC } from "react";
import { QuestionAnswer } from "../types/QuestionAnswer";
import { QuestionAnswerHistory } from "./QuestionAnswerHistory";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  answerHistory: Array<Answer>;
};

const questionAnswers: Array<QuestionAnswer> = [
  {
    question: "サブウェポンはサブウェポン名がスプラッシュシールド？",
    answer: false,
  },
  {
    question: "スペシャルウェポンはスペシャルウェポン名がウルトラショット？",
    answer: true,
  },
  {
    question: "メインウェポンはブキ種がシューター？",
    answer: true,
  },
];

export const GameStartModal: FC<Props> = (props) => {
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
        <Typography variant="h4">How to Play</Typography>
        <Box sx={{ alignItems: "left", width: "600px" }}>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography>
            スプラトゥーン3のブキを当てるクイズゲームです。
          </Typography>
          <Typography>
            質問をするとYESかNOで回答が返ってくるので、できるだけ少ない質問数でブキを当てましょう。
          </Typography>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography variant="h6">例</Typography>
          <QuestionAnswerHistory questionAnswers={questionAnswers} />
          <Typography sx={{ marginTop: "10px" }}>
            例えばこのような質問履歴であれば、答えはスプラシューターとなります。
          </Typography>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography>
            ゲームをスタートするには、スタートボタンをクリックしてください。
          </Typography>
        </Box>
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
