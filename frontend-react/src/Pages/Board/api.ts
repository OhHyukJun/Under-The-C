import axios from "axios";

//const URI = "http://localhost:4000/posts";
const URI = `${process.env.SPRING_HOST}:${process.env.SPRING_PORT}/evaluation/add`;

export const lectorePost = async (data: any) => {
    data.rating = parseInt(data.rating);
    const res = await axios.post(URI, data);
    return res.data;
  };