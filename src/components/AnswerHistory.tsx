import { FC } from "react";
import { Answer } from "../types/Answer";
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";

type Props = {
  answerHistory: Array<Answer>;
};

export const AnswerHistory: FC<Props> = (props) => {
  const { answerHistory } = props;
  return (
    <Paper sx={{ width: "100%", padding: 5, boxSizing: "border-box" }}>
      <p style={{ fontWeight: "bold" }}>回答履歴</p>
      <TableContainer sx={{ maxHeight: 400 }}>
        <Table stickyHeader>
          <TableHead>
            <TableRow>
              <TableCell align="center">答え</TableCell>
              <TableCell align="center">質問回数</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {answerHistory.map((answer) => {
              return (
                <TableRow>
                  <TableCell>{answer.weapon}</TableCell>
                  <TableCell>{answer.questionCount}</TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
};
