import {
  Autocomplete,
  AutocompleteChangeDetails,
  AutocompleteChangeReason,
  Button,
  Card,
  Modal,
  TextField,
  Typography,
} from "@mui/material";
import { FC, useEffect, useState } from "react";
import { Question } from "../types/Question";
import { QuestionAnswer } from "../types/QuestionAnswer";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  questions: Array<Question>;
  questionAnswers: Array<QuestionAnswer>;
  setQuestionAnswers: (questionAnswers: Array<QuestionAnswer>) => void;
};

const question4Set = ["以上？", "以下？", "？"];

export const QuestionModal: FC<Props> = (props) => {
  const { open, setOpen, questions } = props;
  const [question1Select, setQuestion1Select] = useState<string>("");
  const [question2Select, setQuestion2Select] = useState<string>("");
  const [question3Select, setQuestion3Select] = useState<string>("");
  const [question4Select, setQuestion4Select] = useState<string>("");
  const [question2Set, setQuestion2Set] = useState<Array<string>>([]);
  const [question3Set, setQuestion3Set] = useState<Array<string>>([]);
  const [selectedQuestion, setSelectedQuestion] = useState<Question>();
  const [disabled, setDisabled] = useState<boolean>(true);

  const handleClose = (_event: {}, _reason: string) => {
    setQuestion1Select("");
    setQuestion2Select("");
    setQuestion3Select("");
    setQuestion4Select("");
    setOpen(false);
  };
  const question1Set = Array.from(
    new Set(questions.map((q) => q.questions[0]))
  );
  useEffect(() => {
    const question2List = questions
      .filter((q) => q.questions[0] === question1Select)
      .filter((q) => q.questions[1])
      .map((q) => q.questions[1]);
    setQuestion2Set(Array.from(new Set(question2List)));
    setQuestion2Select("");
    setQuestion3Select("");
    setQuestion4Select("");
  }, [question1Select]);
  useEffect(() => {
    const question3List = questions
      .filter((q) => q.questions[1] === question2Select)
      .filter((q) => q.questions[2])
      .map((q) => q.questions[2]);
    setQuestion3Set(Array.from(new Set(question3List)));
    setQuestion3Select("");
    setQuestion4Select("");
  }, [question2Select]);

  useEffect(() => {
    const selected = questions.find(
      (q) =>
        q.questions[0] === question1Select &&
        q.questions[1] === question2Select &&
        (q.questions[2] ? q.questions[2] === question3Select : true)
    );
    setSelectedQuestion(selected);
  }, [question1Select, question2Select, question3Select]);

  useEffect(() => {
    if (question1Select === "") {
      setDisabled(true);
      return;
    }
    if (question2Select === "" && question2Set.length !== 0) {
      setDisabled(true);
      return;
    }
    if (selectedQuestion?.isNumeric && question3Select === "") {
      setDisabled(true);
      return;
    }
    if (question3Select === "" && question3Set.length !== 0) {
      setDisabled(true);
      return;
    }
    if (selectedQuestion?.isComparable && question4Select === "") {
      setDisabled(true);
      return;
    }
    setDisabled(false);
  }, [
    question1Select,
    question2Select,
    question3Select,
    question4Select,
    question2Set,
    question3Set,
  ]);

  const handleClickQuestion = (_event: React.MouseEvent<HTMLButtonElement>) => {
    const questionString =
      question1Select + question2Select + question3Select + question4Select;
    const answer = Math.random() < 0.5;
    props.setQuestionAnswers([
      { question: questionString, answer },
      ...props.questionAnswers,
    ]);
    setQuestion1Select("");
    setQuestion2Select("");
    setQuestion3Select("");
    setQuestion4Select("");
    setOpen(false);
  };
  const handleQuestion1Change = (
    _event: React.SyntheticEvent,
    value: string | null,
    _reason: AutocompleteChangeReason,
    _details?: AutocompleteChangeDetails<string>
  ) => {
    setQuestion1Select(value || "");
  };
  const handleQuestion2Change = (
    _event: React.SyntheticEvent,
    value: string | null,
    _reason: AutocompleteChangeReason,
    _details?: AutocompleteChangeDetails<string>
  ) => {
    setQuestion2Select(value || "");
  };
  const handleQuestion3Change = (
    _event: React.SyntheticEvent,
    value: string | null,
    _reason: AutocompleteChangeReason,
    _details?: AutocompleteChangeDetails<string>
  ) => {
    setQuestion3Select(value || "");
  };
  const handleQuestionNumberChange = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setQuestion3Select(event.target.value);
  };
  const handleQuestion4Change = (
    _event: React.SyntheticEvent,
    value: string | null,
    _reason: AutocompleteChangeReason,
    _details?: AutocompleteChangeDetails<string>
  ) => {
    setQuestion4Select(value || "");
  };
  return (
    <Modal open={open} onClose={handleClose} sx={{}}>
      <Card
        sx={{
          width: "600px",
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
        <Autocomplete
          sx={{
            width: "100%",
          }}
          options={question1Set}
          getOptionLabel={(option) => option}
          value={question1Select}
          onChange={handleQuestion1Change}
          renderInput={(params) => (
            <TextField {...params} label="質問1" variant="outlined" />
          )}
        />
        {question2Set.length === 0 ? null : (
          <Autocomplete
            sx={{
              width: "100%",
              marginTop: "10px",
            }}
            options={question2Set}
            getOptionLabel={(option) => option}
            onChange={handleQuestion2Change}
            value={question2Select}
            renderInput={(params) => (
              <TextField {...params} label="質問2" variant="outlined" />
            )}
          />
        )}
        {question3Set.length === 0 ? null : (
          <Autocomplete
            sx={{
              width: "100%",
              marginTop: "10px",
            }}
            options={question3Set}
            getOptionLabel={(option) => option}
            onChange={handleQuestion3Change}
            value={question3Select}
            renderInput={(params) => (
              <TextField {...params} label="質問3" variant="outlined" />
            )}
          />
        )}
        {selectedQuestion?.isNumeric ? (
          <div style={{ display: "flex", width: "100%", alignItems: "center" }}>
            <TextField
              sx={{ width: "90%", marginTop: "10px" }}
              label="数値"
              variant="outlined"
              type="number"
              value={question3Select}
              onChange={handleQuestionNumberChange}
            />
            <Typography sx={{ width: "10%", marginLeft: "10px" }}>
              度
            </Typography>
          </div>
        ) : null}
        {selectedQuestion?.isComparable ? (
          <Autocomplete
            sx={{
              width: "100%",
              marginTop: "10px",
            }}
            options={question4Set}
            getOptionLabel={(option) => option}
            onChange={handleQuestion4Change}
            value={question4Select}
            renderInput={(params) => (
              <TextField {...params} label="比較" variant="outlined" />
            )}
          />
        ) : null}

        <Button
          variant="contained"
          sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
          onClick={handleClickQuestion}
          disabled={disabled}
        >
          質問する
        </Button>
      </Card>
    </Modal>
  );
};
