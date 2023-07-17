import axios from "axios";
//import Member from './Member';

//const URI = "http://localhost:4000/members";
const URI = `${process.env.SPRING_HOST}:${process.env.SPRING_PORT}/user/add`;

export const memberPost = async (data: any) => {
    const res = await axios.post(URI, data);
    return res.data;
  };