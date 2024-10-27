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

/**
 * AnswerHistoryコンポーネントのプロパティ
 * @param answerHistory 回答履歴
 * @param onClick テーブルの行をクリックした際のコールバック関数
 */
type Props = {
  answerHistory: Array<Answer>;
  onClick?: (answer: Answer) => void;
};

/**
 * 回答履歴コンポーネント
 * @param props プロパティ
 * @returns AnswerHistoryコンポーネント
 */
export const AnswerHistory: FC<Props> = (props) => {
  const { answerHistory, onClick } = props;
  return (
    <Paper
      data-testid="answer-history"
      sx={{ width: "100%", padding: 5, boxSizing: "border-box" }}
    >
      <p style={{ fontWeight: "bold" }}>回答履歴</p>
      <TableContainer sx={{ maxHeight: 400 }}>
        <Table stickyHeader>
          <TableHead>
            <TableRow>
              <TableCell align="center">答えのブキ</TableCell>
              <TableCell align="center">正解/不正解</TableCell>
              <TableCell align="center">質問回数</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {answerHistory.map((answer, index) => {
              return (
                <TableRow
                  key={index}
                  onClick={() => onClick && onClick(answer)}
                >
                  <TableCell>{answer.weapon}</TableCell>
                  {answer.isCorrect ? (
                    <TableCell align="center" style={{ color: "#2e7d32" }}>
                      正解
                    </TableCell>
                  ) : (
                    <TableCell align="center" style={{ color: "#d32f2f" }}>
                      不正解
                    </TableCell>
                  )}
                  <TableCell>{answer.questionHistory.length}</TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
};
