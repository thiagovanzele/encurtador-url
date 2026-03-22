import { useState } from "react";
import { Container, FormContainer, InputContainer } from "./styles";
import { api } from "./api";
import logo from "./assets/logo.png";

function App() {
  const [urlOriginal, setUrlOriginal] = useState<string>("");
  const [urlEncurtada, setUrlEncurtada] = useState<string>("");

  async function handleEncurtarUrl(): Promise<void> {
    const response = await api.post("/encurtar", {
      url: urlOriginal,
    });

    setUrlEncurtada(response.data);
  }

  return (
    <Container>
      <img src={logo} alt="logo do encurtador" />
      <FormContainer>
        <InputContainer>
          <label htmlFor="url-original">URL Original</label>

          <input
            name="url-original"
            id="url-original"
            type="text"
            value={urlOriginal}
            onChange={(e) => setUrlOriginal(e.target.value)}
          />

          <button disabled={!urlOriginal} onClick={handleEncurtarUrl}>
            Encurtar URL
          </button>
        </InputContainer>

        {urlEncurtada && (
          <InputContainer>
            <label htmlFor="url-encurtada">URL Encurtada</label>

            <a href={urlEncurtada} target="_blank" rel="noopener noreferrer">
              {urlEncurtada}
            </a>
          </InputContainer>
        )}
      </FormContainer>
    </Container>
  );
}

export default App;
