class ClassController < ApplicationController
	def new

     @roomDetails = Array.new
     Room.all.each do |room|
       @building_id = room.building_id;
       @building_name = Building.find_by_id(@building_id).building_name;
       @details =  @building_name + " " + room.room_name;
       @roomDetails << @details;
     end

	end

	 def show
	 	 render plain: ClassroomTiming.all.inspect
     end

     def create
      @room_details = params[:class][:name];
      @slot_details = params[:class][:slot_name]
      @split_details = @room_details.split(' ')
      @building_name = @split_details[0];
      @room_name = @split_details[1];
      @building_id = Building.where(:building_name => @building_name).pluck(:building_id);
      @room_id = Room.where(:room_name => @room_name).pluck(:room_id);
      @timeslot_id = TimeSlot.where(:slot_num => @slot_details).pluck(:timeslot_id);
      @class = ClassroomTiming.create(:room_id => @room_id, :timeslot_id => @timeslot_id);
      render plain: @class.inspect
     end

     def destroy
     	#put here code to delete
        redirect_to class_index_path
     end
end
