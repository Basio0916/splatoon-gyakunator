import { Box, Button, Card, Divider, Modal, Typography } from "@mui/material";
import { FC } from "react";
import { QuestionAnswer } from "../types/QuestionAnswer";
import { QuestionAnswerHistory } from "./QuestionAnswerHistory";
import { AnswerStatus } from "../types/AnswerStatus";
import PanoramaFishEyeIcon from "@mui/icons-material/PanoramaFishEye";
import ClearIcon from "@mui/icons-material/Clear";
import ChangeHistoryIcon from "@mui/icons-material/ChangeHistory";

/**
 * HowToPlayModalコンポーネントのプロパティ
 * @param open モーダルの表示状態
 * @param setOpen モーダルの表示状態を変更する関数
 * @param onClose モーダルを閉じたときのコールバック関数
 */
type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  onClose?: () => void;
};

/**
 * ゲームの説明を表示するモーダルコンポーネント
 * @param props プロパティ
 * @returns HowToPlayModalコンポーネント
 */
export const HowToPlayModal: FC<Props> = (props) => {
  const { open, setOpen, onClose } = props;
  const handleClose = (_event: {}, reason: string) => {
    if (reason !== "backdropClick") {
      setOpen(false);
    }
  };
  const handleClickStart = (_event: React.MouseEvent<HTMLButtonElement>) => {
    setOpen(false);
    if (onClose) {
      onClose();
    }
  };
  const questionAnswers: Array<QuestionAnswer> = [
    {
      question: "サブウェポンはサブウェポン名がスプラッシュシールド？",
      answer: AnswerStatus.No,
    },
    {
      question: "スペシャルウェポンはスペシャルウェポン名がグレートバリア？",
      answer: AnswerStatus.Yes,
    },
    {
      question: "メインウェポンはブキ種がシューター？",
      answer: AnswerStatus.Yes,
    },
  ];
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
          maxHeight: "90%",
        }}
      >
        <Typography variant="h4">How to Play</Typography>
        <Box sx={{ alignItems: "left", width: "90%", maxWidth: "600px" }}>
          <Divider sx={{ width: "100%", margin: "10px 0px" }} />
          <Typography>
            スプラトゥーン3のブキを当てるクイズゲームです。
          </Typography>
          <Typography>
            質問をすると
            <PanoramaFishEyeIcon
              style={{ color: "2e7d32", verticalAlign: "-10%" }}
            />
            （はい）か
            <ClearIcon style={{ color: "#d32f2f", verticalAlign: "-10%" }} />
            （いいえ）か
            <ChangeHistoryIcon
              style={{ color: "#E3D026", verticalAlign: "-10%" }}
            />
            （部分的にはい）で回答が返ってくるので、できるだけ少ない質問数でブキを当てましょう。
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
