import { Box, CircularProgress, Modal } from "@mui/material";
import { FC } from "react";

/**
 * ProgressModalコンポーネントのプロパティ
 * @param open モーダルの表示状態
 */
type Props = {
  open: boolean;
};

/**
 * 通信中に表示されるモーダルコンポーネント
 * @param props プロパティ
 * @returns ProgressModalコンポーネント
 */
export const ProgressModal: FC<Props> = (props) => {
  const { open } = props;

  return (
    <Modal open={open}>
      <Box
        sx={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "100vh",
        }}
      >
        <CircularProgress sx={{ color: "white" }} />
      </Box>
    </Modal>
  );
};
