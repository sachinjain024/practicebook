import pandas as pd
import string

def clean_data(df):
    print('++++++++++++++++++++++++++Cleaning dataset...')

    # In the dataset we have two kind of rows (Row which specify only country and Row which specify the segment and revenue for that country)
    # Prefill country name in the rows which contain segment and revenue
    df['Country'] = df['Country'].fillna(method='ffill')

    # Filter out the rows which specify only country because this information has already been merged into other rows
    df = df.dropna(subset = ['Segment'])

    # Remove '$' character from revenue so that mathematical operations can be performed
    df['Revenue'] = df['Revenue'].apply(lambda value: float(value.replace('$', '')))

    return df

def compute_revenue_by_country(df):
    print('++++++++++++++++++++++Computing revenue by country...')
    print(df.groupby('Country')['Revenue'].sum())

def remove_punctuation(text):
    translator = str.maketrans('', '', string.punctuation)

    if type(text) is str:
        return text.translate(translator)
    else:
        return text

def compute_revenue_by_audience_term(df):
    print('++++++++++++++++++++++Computing revenue by each segment term...')

    # Remove punctuation characters from the segment name
    df['Term'] = df['Segment'].apply(remove_punctuation)

    # Extract important terms from Segment Name and explode the list of words into multiple rows and reindex the dataframe
    df = (df.set_index(df.columns.drop('Term', 1).tolist())
         .Term.str.split(expand=True)
         .stack()
         .reset_index()
         .rename(columns={0:'Term'})
         .loc[:, df.columns]
         )

    print(df.groupby('Term')['Revenue'].sum())


segment_data = pd.read_csv('challenge_dataset.csv')
segment_data = clean_data(segment_data)
print(segment_data.head())

compute_revenue_by_country(segment_data)
compute_revenue_by_audience_term(segment_data)
