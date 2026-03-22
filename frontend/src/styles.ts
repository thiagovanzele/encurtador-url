import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  background: linear-gradient(180deg, #1a1919, #242424);
  width: 100%;
  height: 100vh;

  img {
    width: 700px;
  }
`;

export const InputContainer = styled.div`
  display: grid;
  grid-template-columns: 180px 400px auto;
  align-items: center;
  gap: 15px;

  > label {
    text-align: right;
    color: #a3a3a3;
    font-size: 18px;
  }

  > input {
    padding: 14px;
    border-radius: 8px;
    border: 1px solid rgba(255, 255, 255, 0.08);
    background-color: #1a1a1a;
    outline: none;
    color: #fff;
    font-size: 18px;
    letter-spacing: 0.1rem;

    &:focus {
      outline: 1px solid green;
    }
  }

  > button {
    grid-column: 3;
    padding: 14px 22px;
    border-radius: 8px;
    border: none;
    background: #1b9e4b;
    color: white;
    font-weight: 600;
    cursor: pointer;

    &:disabled {
      background-color: #222222;
      cursor: not-allowed;
      color: #6d6d6d;
      border: 1px solid #2e2e2e;
    }
  }

  a {
    grid-column: 2;
    padding: 14px;
    border-radius: 8px;
    background-color: #1a1a1a;
    border: 1px solid rgba(255, 255, 255, 0.08);
    color: #3b82f6;
    text-decoration: none;
    font-size: 18px;

    &:hover {
      text-decoration: underline;
    }
  }
`;

export const FormContainer = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;
`;
