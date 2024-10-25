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
import { filterOptions } from "./FilterOptions";

/**
 * SubmissionModalコンポーネントのプロパティ
 */
type Props = {
  open: boolean;
  setOpen: (open: boolean) => void;
  weapons: Array<string>;
  onClose: (selectedWeapon: string) => void;
};

/**
 * 回答を提出する際に表示されるモーダルコンポーネント
 * @param props プロパティ
 * @returns SubmissionModalコンポーネント
 */
export const SubmissionModal: FC<Props> = (props) => {
  const { open, setOpen, weapons, onClose } = props;
  const [selectedWeapon, setSelectedWeapon] = useState<string>("");
  const [disabled, setDisabled] = useState<boolean>(true);

  const handleClose = (_event: {}, _reason: string) => {
    setSelectedWeapon("");
    setOpen(false);
  };

  const handleClickCloseIcon = (
    _event: React.MouseEvent<HTMLButtonElement>
  ) => {
    setSelectedWeapon("");
    setOpen(false);
  };

  const handleWeaponChange = (
    _event: React.SyntheticEvent,
    value: string | null,
    _reason: AutocompleteChangeReason,
    _details?: AutocompleteChangeDetails<string>
  ) => {
    if (value) {
      setSelectedWeapon(value);
    }
  };

  useEffect(() => {
    setDisabled(selectedWeapon === "");
  }, [selectedWeapon]);

  const handleClickAnswer = async (
    _event: React.MouseEvent<HTMLButtonElement>
  ) => {
    setOpen(false);
    onClose(selectedWeapon);
    setSelectedWeapon("");
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
          value={selectedWeapon}
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
