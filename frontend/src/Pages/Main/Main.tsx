import { Header } from '../../Layout/Header';
import { useQuery, useQueryClient } from '@tanstack/react-query';
import { Lecture } from './Lecture';
import axios from "axios";

const URI = "http://localhost:4000/posts";

export interface LectureI {
  id: number;
  title: string;
  professor: string;
  lecture: string;
  rating: number;
}

const fetchData = async () => {
  const res = await axios.get(URI);
  return res.data;
}

const Main = () => {
  const { isLoading, isError, data } = useQuery(['lecture'], fetchData);

  if (isLoading)
    return <h2>Loading...</h2>
	
	if (isError)
		return <h2>Error...</h2>

  return (
    <>
      <Header />
      <h1>Main page</h1>
      {
				data?.map((item: LectureI) => {
					return <Lecture key={item.id} {...item} /> })
	 		}
    </>
  );
};

export default Main;