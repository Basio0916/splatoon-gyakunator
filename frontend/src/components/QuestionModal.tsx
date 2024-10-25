import {
  Autocomplete,
  AutocompleteChangeDetails,
  AutocompleteChangeReason,
  Box,
  Button,
  Card,
  IconButton,
  Modal,
  TextField,
  Typography,
} from "@mui/material";
import { FC, useEffect, useState } from "react";
import { Prompt } from "../types/Prompt";
import CloseIcon from "@mui/icons-material/Close";
import { filterOptions } from "../utils/FilterOptions";

/**
 * QuestionModalコンポーネントのプロパティ
 * @param open モーダルの表示状態
 * @param setOpen モーダルの表示状態を変更する関数
 * @param questions 質問リスト
 * @param onClose モーダルを閉じたときのコールバック関数
 */
type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  questions: Array<Prompt>;
  onClose: (
    questionString: string,
    questionName: string,
    option: string,
    comparator: string
  ) => void;
};

/**
 * 質問をする際に表示されるモーダルコンポーネント
 * @param props プロパティ
 * @returns QuestionModalコンポーネント
 */
export const QuestionModal: FC<Props> = (props) => {
  const { open, setOpen, questions, onClose } = props;
  const [question1Select, setQuestion1Select] = useState<string>("");
  const [question2Select, setQuestion2Select] = useState<string>("");
  const [question3Select, setQuestion3Select] = useState<string>("");
  const [question4Select, setQuestion4Select] = useState<string>("");
  const [question2Set, setQuestion2Set] = useState<Array<string>>([]);
  const [question3Set, setQuestion3Set] = useState<Array<string>>([]);
  const [selectedQuestion, setSelectedQuestion] = useState<Prompt>();
  const [disabled, setDisabled] = useState<boolean>(true);
  const [unit, setUnit] = useState<string>("");
  const [isFocused, setIsFocused] = useState<boolean>(false);

  const question4Set = ["以上？", "以下？", "？"];

  const handleClick = () => {
    if (!isFocused) {
      setIsFocused(true);
    } else {
      setIsFocused(false);
    }
  };

  const handleBlur = () => {
    setIsFocused(false);
  };

  const handleClose = (_event: {}, _reason: string) => {
    setQuestion1Select("");
    setQuestion2Select("");
    setQuestion3Select("");
    setQuestion4Select("");
    setOpen(false);
  };
  const question1Set = Array.from(new Set(questions.map((q) => q.prompts[0])));
  useEffect(() => {
    const question2List = questions
      .filter((q) => q.prompts[0] === question1Select)
      .filter((q) => q.prompts[1])
      .map((q) => q.prompts[1]);
    setQuestion2Set(Array.from(new Set(question2List)));
    setQuestion2Select("");
    setQuestion3Select("");
    setQuestion4Select("");
  }, [question1Select]);
  useEffect(() => {
    const question3List = questions
      .filter((q) => q.prompts[1] === question2Select)
      .filter((q) => q.prompts[2])
      .map((q) => q.prompts[2]);
    setQuestion3Set(Array.from(new Set(question3List)));
    setQuestion3Select("");
    setQuestion4Select("");
    const unit = questions.find((q) => q.prompts[1] === question2Select)?.unit;
    setUnit(unit || "");
  }, [question2Select]);

  useEffect(() => {
    const selected = questions.find(
      (q) =>
        q.prompts[0] === question1Select &&
        q.prompts[1] === question2Select &&
        (q.prompts[2] ? q.prompts[2] === question3Select : true)
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

  const handleClickQuestion = async (
    _event: React.MouseEvent<HTMLButtonElement>
  ) => {
    setOpen(false);

    const questionString =
      question1Select +
      question2Select +
      question3Select +
      selectedQuestion?.unit +
      question4Select;
    onClose(
      questionString,
      selectedQuestion?.questionName || "",
      question3Select,
      question4Select
    );

    setQuestion1Select("");
    setQuestion2Select("");
    setQuestion3Select("");
    setQuestion4Select("");
  };
  const handleClickCloseIcon = (
    _event: React.MouseEvent<HTMLButtonElement>
  ) => {
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
          width: "90%",
          maxWidth: "600px",
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
        <IconButton
          aria-label="close"
          onClick={handleClickCloseIcon}
          sx={{
            position: "absolute",
            right: 8,
            top: 8,
            color: (theme) => theme.palette.grey[500],
          }}
        >
          <CloseIcon />
        </IconButton>
        <Box sx={{ height: "20px" }}></Box>
        <Autocomplete
          sx={{
            width: "100%",
          }}
          options={question1Set}
          getOptionLabel={(option) => option}
          value={question1Select}
          onChange={handleQuestion1Change}
          filterOptions={filterOptions}
          blurOnSelect="touch"
          renderInput={(params) => (
            <TextField
              {...params}
              label="質問1"
              variant="outlined"
              onClick={handleClick}
              onBlur={handleBlur}
              inputProps={{
                ...params.inputProps,
                inputMode: isFocused ? "none" : "text",
              }}
            />
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
            filterOptions={filterOptions}
            value={question2Select}
            renderInput={(params) => (
              <TextField
                {...params}
                label="質問2"
                variant="outlined"
                onClick={handleClick}
                onBlur={handleBlur}
                inputProps={{
                  ...params.inputProps,
                  inputMode: isFocused ? "none" : "text",
                }}
              />
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
            filterOptions={filterOptions}
            value={question3Select}
            renderInput={(params) => (
              <TextField
                {...params}
                label="質問3"
                variant="outlined"
                onClick={handleClick}
                onBlur={handleBlur}
                inputProps={{
                  ...params.inputProps,
                  inputMode: isFocused ? "none" : "text",
                }}
              />
            )}
          />
        )}
        {selectedQuestion?.isNumeric ? (
          <div style={{ display: "flex", width: "100%", alignItems: "center" }}>
            <TextField
              sx={{ width: "85%", marginTop: "10px" }}
              label="数値"
              variant="outlined"
              type="number"
              value={question3Select}
              onChange={handleQuestionNumberChange}
            />
            <Typography sx={{ width: "15%", marginLeft: "10px" }}>
              {unit}
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
              <TextField
                {...params}
                label="比較"
                variant="outlined"
                onClick={handleClick}
                onBlur={handleBlur}
                inputProps={{
                  ...params.inputProps,
                  inputMode: isFocused ? "none" : "text",
                }}
              />
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
