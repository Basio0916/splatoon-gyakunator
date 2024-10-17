import { Box, CircularProgress, Modal } from "@mui/material";
import { FC } from "react";

type Props = {
  open: boolean;
};

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
