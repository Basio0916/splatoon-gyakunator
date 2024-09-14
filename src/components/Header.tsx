import { Box, Typography } from "@mui/material";
import { FC } from "react";

/**
 * ヘッダーを表すコンポーネント
 */
export const Header: FC = () => {
  return (
    <Box
      sx={{
        backgroundColor: "#eee",
        textAlign: "center",
        fontSize: "24px",
        margin: "0px",
        padding: "20px",
      }}
    >
      <Typography variant="h4">Splatoon Gyakunator</Typography>
    </Box>
  );
};
