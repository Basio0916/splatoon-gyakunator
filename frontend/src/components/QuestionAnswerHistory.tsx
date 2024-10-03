import { FC } from "react";
import { QuestionAnswer } from "../types/QuestionAnswer";
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
  questionAnswers: Array<QuestionAnswer>;
};

export const QuestionAnswerHistory: FC<Props> = (props) => {
  const { questionAnswers } = props;

  return (
    <Paper sx={{ width: "100%", padding: 5, boxSizing: "border-box" }}>
      <p style={{ fontWeight: "bold" }}>質問履歴</p>
      <TableContainer sx={{ maxHeight: 400 }}>
        <Table stickyHeader>
          <TableHead>
            <TableRow>
              <TableCell>No.</TableCell>
              <TableCell>質問</TableCell>
              <TableCell>結果</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {questionAnswers.map((qa, index) => {
              return (
                <TableRow key={index}>
                  <TableCell>{questionAnswers.length - index}</TableCell>
                  <TableCell>{qa.question}</TableCell>
                  {qa.answer ? (
                    <TableCell style={{ color: "#2e7d32", fontWeight: "bold" }}>
                      YES
                    </TableCell>
                  ) : (
                    <TableCell style={{ color: "#d32f2f", fontWeight: "bold" }}>
                      NO
                    </TableCell>
                  )}
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
};
