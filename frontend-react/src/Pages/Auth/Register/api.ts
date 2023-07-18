import axios from "axios";

const URI = `http://localhost:${process.env.REACT_APP_SPRING_PORT}/user/add`;

export const memberPost = async (data: any) => {
  console.log("URI:", URI);
  const res = await axios.post(URI, data);
  return res.data;
};
