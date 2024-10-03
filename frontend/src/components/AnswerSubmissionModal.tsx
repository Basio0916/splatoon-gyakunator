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
} from "@mui/material";
import { FC, useEffect, useState } from "react";
import CloseIcon from "@mui/icons-material/Close";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  weapons: Array<string>;
  onClose: (weapon: string, result: boolean) => void;
};

export const AnswerSubmissionModal: FC<Props> = (props) => {
  const { open, setOpen, weapons, onClose } = props;
  const [weaponSelect, setWeaponSelect] = useState<string>("");
  const [disabled, setDisabled] = useState<boolean>(true);

  const handleClose = (_event: {}, _reason: string) => {
    setWeaponSelect("");
    setOpen(false);
  };

  const handleClickCloseIcon = (
    _event: React.MouseEvent<HTMLButtonElement>
  ) => {
    setWeaponSelect("");
    setOpen(false);
  };

  const handleWeaponChange = (
    _event: React.SyntheticEvent,
    value: string | null,
    _reason: AutocompleteChangeReason,
    _details?: AutocompleteChangeDetails<string>
  ) => {
    if (value) {
      setWeaponSelect(value);
    }
  };

  useEffect(() => {
    setDisabled(weaponSelect === "");
  }, [weaponSelect]);

  const handleClickAnswer = (_event: React.MouseEvent<HTMLButtonElement>) => {
    const result = Math.random() < 0.5;
    setWeaponSelect("");
    setOpen(false);
    onClose(weaponSelect, result);
  };

  const toKatakana = (input: string): string => {
    return input.replace(/[\u3041-\u3096]/g, (char) =>
      String.fromCharCode(char.charCodeAt(0) + 0x60)
    );
  };

  const toHiragana = (input: string): string => {
    return input.replace(/[\u30A1-\u30F6]/g, (char) =>
      String.fromCharCode(char.charCodeAt(0) - 0x60)
    );
  };

  const filterOptions = (
    options: string[],
    { inputValue }: { inputValue: string }
  ) => {
    const lowerCaseInput = inputValue.toLowerCase();
    const katakanaInput = toKatakana(lowerCaseInput);
    const hiraganaInput = toHiragana(lowerCaseInput);

    return options.filter((option) => {
      const lowerCaseOption = option.toLowerCase();

      return (
        lowerCaseOption.includes(lowerCaseInput) ||
        lowerCaseOption.includes(katakanaInput) ||
        lowerCaseOption.includes(hiraganaInput)
      );
    });
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
          options={weapons}
          getOptionLabel={(option) => option}
          value={weaponSelect}
          onChange={handleWeaponChange}
          filterOptions={filterOptions}
          renderInput={(params) => (
            <TextField {...params} label="回答" variant="outlined" />
          )}
        />

        <Button
          variant="contained"
          sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
          onClick={handleClickAnswer}
          disabled={disabled}
        >
          回答する
        </Button>
      </Card>
    </Modal>
  );
};
