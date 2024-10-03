import { Box, Button, Card, Divider, Modal, Typography } from "@mui/material";
import { FC } from "react";
import { QuestionAnswer } from "../types/QuestionAnswer";
import { QuestionAnswerHistory } from "./QuestionAnswerHistory";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
};

const questionAnswers: Array<QuestionAnswer> = [
  {
    question: "サブウェポンはサブウェポン名がスプラッシュシールド？",
    answer: false,
  },
  {
    question: "スペシャルウェポンはスペシャルウェポン名がグレートバリア？",
    answer: true,
  },
  {
    question: "メインウェポンはブキ種がシューター？",
    answer: true,
  },
];

export const HowToPlayModal: FC<Props> = (props) => {
  const { open, setOpen } = props;
  const handleClose = (_event: {}, reason: string) => {
    if (reason !== "backdropClick") {
      setOpen(false);
    }
  };
  const handleClickStart = (_event: React.MouseEvent<HTMLButtonElement>) => {
    setOpen(false);
  };
  return (
    <Modal open={open} onClose={handleClose} sx={{}}>
      <Card
        sx={{
          width: "90%",
          maxWidth: "800px",
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
        <Box sx={{ alignItems: "left", width: "90%", maxWidth: "600px" }}>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography>
            スプラトゥーン3のブキを当てるクイズゲームです。
          </Typography>
          <Typography>
            質問をするとYESかNOで回答が返ってくるので、できるだけ少ない質問数でブキを当てましょう。
          </Typography>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography
            variant="h6"
            sx={{ fontWeight: "bold", margin: "5px 0px" }}
          >
            例
          </Typography>
          <Typography sx={{ marginTop: "10px" }}>
            例えばこのような質問履歴であれば、答えはわかばシューターとなります。
          </Typography>
          <QuestionAnswerHistory questionAnswers={questionAnswers} />
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography
            variant="h6"
            sx={{ fontWeight: "bold", margin: "5px 0px" }}
          >
            補足ルール
          </Typography>
          <Typography>
            本ゲームではレプリカブキは回答にはなりません。
          </Typography>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography>
            ゲームをスタートするには、スタートボタンをクリックしてください。
          </Typography>
        </Box>
        <Button
          variant="contained"
          sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
          onClick={handleClickStart}
        >
          スタート
        </Button>
      </Card>
    </Modal>
  );
};
