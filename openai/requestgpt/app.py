from gpt_index import SimpleDirectoryReader, GPTListIndex, LLMPredictor, PromptHelper
from langchain.chat_models import ChatOpenAI
from llama_index import download_loader, GPTSimpleVectorIndex
import gradio as gr
import sys
import os

def get_all_documentation_links():
    sitemap_xml = 'https://docs.requestly.io/sitemap.xml'

    ###
    # Write code here that fetches the sitemap and creates a list of unique URLs
    # For now hardcoding the list of URLs
    ###

    return [
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/overview',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/redirect-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/replace-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/headers-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/request-body-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/response-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/query-params-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/cookies-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/script-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/user-agent-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/delay-rule',
        'https://docs.requestly.io/browser-extension/chrome/http-modifications/cancel-rule'
    ]

def get_all_github_issues_links():
    url_format = "https://github.com/requestly/requestly/issues/{}"
    n_urls = 300 # number of URLs to generate
    urls = []

    for i in range(100,n_urls):
        url = url_format.format(i)
        urls.append(url)

    return urls

def get_all_links():
    docs_links = get_all_documentation_links()
    github_issues_links = get_all_github_issues_links()

    return docs_links + github_issues_links

def construct_index(directory_path):
    # max_input_size = 4096
    # num_outputs = 512
    # max_chunk_overlap = 20
    # chunk_size_limit = 600

    # prompt_helper = PromptHelper(max_input_size, num_outputs, max_chunk_overlap, chunk_size_limit=chunk_size_limit)
    # llm_predictor = LLMPredictor(llm=ChatOpenAI(temperature=0.7, model_name="gpt-3.5-turbo", max_tokens=num_outputs))

    BeautifulSoupWebReader = download_loader("BeautifulSoupWebReader")
    loader = BeautifulSoupWebReader()
    documents = loader.load_data(
        urls=get_all_links()
    )

    # index = GPTSimpleVectorIndex(documents, llm_predictor=llm_predictor, prompt_helper=prompt_helper)
    index = GPTSimpleVectorIndex.from_documents(documents)
    index.save_to_disk('index.json')

    return index

def chatbot(input_text):
    index = GPTSimpleVectorIndex.load_from_disk('index.json')
    response = index.query(input_text, response_mode="compact")
    return response.response

iface = gr.Interface(fn=chatbot,
                     inputs=gr.components.Textbox(lines=7, label="Enter your text"),
                     outputs="text",
                     title="Requestly AI Assistant")

index = construct_index("docs")
iface.launch(share=True)