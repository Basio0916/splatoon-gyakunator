import {
  Autocomplete,
  AutocompleteChangeDetails,
  AutocompleteChangeReason,
  Button,
  Card,
  Modal,
  TextField,
} from "@mui/material";
import { FC, useEffect, useState } from "react";

type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  weapons: Array<string>;
  setWeapon: (weapon: string) => void;
  setAnswer: (answer: boolean) => void;
};

export const AnswerSubmissionModal: FC<Props> = (props) => {
  const { open, setOpen, weapons, setWeapon, setAnswer } = props;
  const [weaponSelect, setWeaponSelect] = useState<string>("");
  const [disabled, setDisabled] = useState<boolean>(true);

  const handleClose = (_event: {}, reason: string) => {
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

  const onClick = (_event: React.MouseEvent<HTMLButtonElement>) => {
    setWeapon(weaponSelect);
    const answer = Math.random() < 0.5;
    setAnswer(answer);
    setWeaponSelect("");
    setOpen(false);
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
          options={weapons}
          getOptionLabel={(option) => option}
          value={weaponSelect}
          onChange={handleWeaponChange}
          renderInput={(params) => (
            <TextField {...params} label="回答" variant="outlined" />
          )}
        />

        <Button
          variant="contained"
          sx={{ width: "150px", fontSize: "18px", marginTop: "10px" }}
          onClick={onClick}
          disabled={disabled}
        >
          回答する
        </Button>
      </Card>
    </Modal>
  );
};
