import React, {useState} from 'react'
import axios from 'axios'

const Pizza = () => {
    const [pizzas, setPizzas] = useState("");

    const viewPizza = async ()=>{
      try {
        const res = await axios.get(`http://localhost:8080/viewPizza`);
        console.log(res.data);
      } catch (error) {
        console.log("Error Found")
      }
       
    }
  return (
    <div>
      {viewPizza()}
    </div>
  )
}

export default Pizza