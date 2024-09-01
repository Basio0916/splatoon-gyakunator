import { styled } from "@mui/material";

export const Header = () => {
  return (
    <SHeader>
      <h2>Splatoon Gyakunator</h2>
    </SHeader>
  );
};

const SHeader = styled("div")`
  background-color: #eee;
  text-align: center;
  font-size: 24px;

  margin: 0px;
  padding: 1px;
`;
